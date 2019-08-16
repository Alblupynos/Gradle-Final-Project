package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest {

    @Rule
    public ActivityTestRule<MainActivity> ActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testAsyncTask() throws InterruptedException, ExecutionException {
        AsyncTaskJoke asyncTaskJoke = new AsyncTaskJoke();
        asyncTaskJoke.execute(ActivityRule.getActivity());
        String joke = asyncTaskJoke.get();
        assertFalse(joke.isEmpty());
        assertNotNull(joke);
    }
}
