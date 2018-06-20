package com.test.demo.springcloudribbon.command;

import com.netflix.hystrix.HystrixObservableCommand;
import com.test.demo.common.pojo.UserDO;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Subscriber;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/6/20 13:32
 * @Update -
 * @Description
 */
public class UserObservableCommand extends HystrixObservableCommand<UserDO> {
    private RestTemplate restTemplate;
    private String name;

    public UserObservableCommand(Setter setter, RestTemplate restTemplate, String name) {
        super(setter);
        this.restTemplate = restTemplate;
        this.name = name;
    }

    @Override
    protected Observable<UserDO> construct() {
        return Observable.create(new Observable.OnSubscribe<UserDO>() {
            @Override
            public void call(Subscriber<? super UserDO> subscriber) {
                try {
                    if (!subscriber.isUnsubscribed()) {
                        UserDO userDO = restTemplate.getForEntity("http://HELLO-SERVICE/users/{1}", UserDO.class, name).getBody();
                        subscriber.onNext(userDO);
                        subscriber.onCompleted();
                    }
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }
}
