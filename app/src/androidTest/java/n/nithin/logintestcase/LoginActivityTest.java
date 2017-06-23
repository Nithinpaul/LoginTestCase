package n.nithin.logintestcase;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by nithin on 6/22/2017.
 */
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule =new ActivityTestRule<LoginActivity>(LoginActivity.class);


    public LoginActivity mLoginActivity=null;

    Instrumentation.ActivityMonitor monitor=getInstrumentation().addMonitor(MainActivity.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        mLoginActivity=mActivityRule.getActivity();

    }


    @Test
    public void testLaunch(){
//        onView(withId(R.id.email)).check(matches(withText("foo@example.com")));
//        onView(withId(R.id.password)).check(matches(withText("hello")));
        onView(withId(R.id.email)).perform(typeText("foo@example.com"));
        onView(withId(R.id.password)).perform(typeText("hello"));
        onView(withId(R.id.email_sign_in_button)).perform(click());




        Activity second=getInstrumentation().waitForMonitorWithTimeout(monitor,500);
        assertNotNull(second);
    }

    @After
    public void tearDown() throws Exception {
        mLoginActivity=null;
    }

}