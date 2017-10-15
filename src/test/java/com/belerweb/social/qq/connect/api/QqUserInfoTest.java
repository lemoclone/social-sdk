package com.belerweb.social.qq.connect.api;

import com.belerweb.social.qq.connect.bean.QqUserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.belerweb.social.TestConfig;
import com.belerweb.social.bean.Result;

public class QqUserInfoTest extends TestConfig {
  final static Logger logger = LoggerFactory.getLogger(QqUserInfoTest.class);

  @Test
  public void testGetUserInfo() {
    String openId = System.getProperty("connect.openid");
    String accessToken = System.getProperty("connect.token");

    Result<QqUserInfo> result =
        connect.getUser().getUserInfo(accessToken, openId);
    Assert.assertTrue(result.success());
    logger.info(result.getResult().getJsonObject().toString());
  }

  @Test
  public void testGetSimpleUserInfo() {
    String openId = System.getProperty("connect.openid");
    String accessToken = System.getProperty("connect.token");

    Result<QqUserInfo> result =
        connect.getUser().getSimpleUserInfo(accessToken, connect.getClientId(), openId);
    Assert.assertTrue(result.success());
    logger.info(result.getResult().getJsonObject().toString());
  }

}
