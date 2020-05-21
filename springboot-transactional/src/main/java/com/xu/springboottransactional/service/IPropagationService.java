package com.xu.springboottransactional.service;

/**
 * 事务传播机制
 *     REQUIRED(0),
 *     SUPPORTS(1),
 *     MANDATORY(2),
 *     REQUIRES_NEW(3),
 *     NOT_SUPPORTED(4),
 *     NEVER(5),
 *     NESTED(6);
 */
public interface IPropagationService {

    void test_REQUIRED();

    void test_REQUIRES_NEW();

    void test_SUPPORTS();

    void test_NOT_SUPPORTED();

    void test_NEVER();

    void test_MANDATORY();

    void test_NESTED();

}
