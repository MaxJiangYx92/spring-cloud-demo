package com.test.demo.springcloudribbon.command;

import com.netflix.hystrix.HystrixCollapser;
import com.netflix.hystrix.HystrixCollapserProperties;
import com.netflix.hystrix.HystrixCommand;
import com.test.demo.common.pojo.UserDO;
import com.test.demo.springcloudribbon.service.UserService;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.netflix.hystrix.HystrixCollapserKey.Factory.asKey;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/6/19 10:35
 * @Update -
 * @Description
 */
public class UserCollapseCommand extends HystrixCollapser<List<UserDO>, UserDO, String> {
    private UserService userService;
    private String name;

    public UserCollapseCommand(UserService userService, String name) {
        super(Setter.withCollapserKey(asKey("userCollapseCommand"))
                .andCollapserPropertiesDefaults(HystrixCollapserProperties.Setter().withTimerDelayInMilliseconds(5000)));
        this.userService = userService;
        this.name = name;
    }

    @Override
    public String getRequestArgument() {
        return name;
    }

    @Override
    protected HystrixCommand<List<UserDO>> createCommand(Collection<CollapsedRequest<UserDO, String>> collapsedRequests) {
        List<String> names = new ArrayList<>(collapsedRequests.size());
        names.addAll(collapsedRequests.stream().map(CollapsedRequest::getArgument).collect(Collectors.toList()));
        return new UserBatchCommand(userService, StringUtils.join(names, ","));
    }

    @Override
    protected void mapResponseToRequests(List<UserDO> batchResponse, Collection<CollapsedRequest<UserDO, String>> collapsedRequests) {
        int count = 0;
        for (CollapsedRequest<UserDO, String> collapsedRequest : collapsedRequests) {
            UserDO userDO = batchResponse.get(count++);
            collapsedRequest.setResponse(userDO);
        }
    }
}
