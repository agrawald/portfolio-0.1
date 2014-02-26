package com.portfolio;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 * Created by e7006722 on 26/02/14.
 */
public abstract class MockTest extends TestCase{

    @Mock
    protected MongoOperations mockMongoOperations;

    @Before
    protected void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {

    }
}
