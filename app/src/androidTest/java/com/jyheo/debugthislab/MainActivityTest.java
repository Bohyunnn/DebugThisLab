package com.jyheo.debugthislab;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        onView(allOf(withId(R.id.Name), isDisplayed()))             //현재 뷰에 id=Name이 있다면
                .perform(click())                                   //click을 실행시에
                .perform(replaceText("john"), closeSoftKeyboard()); //Name이 john으로 변하고

        onView(allOf(withId(R.id.OK), isDisplayed()))    //Ok를 클릭했다면
                .perform(click());                       //Test 실행

        onView(withId(R.id.textview))                    //id=textview가 있다면
                .check(matches(withText("Hello")));      //Hello라는 문자열이 있다면 정상처리

    }

    @Test
    public void mainActivityTest2() {
        onView(allOf(withId(R.id.Name), isDisplayed()))  //id가 Name인게 있다면
                .perform(click())                        //click이 실행시에
                .perform(replaceText("john2"), closeSoftKeyboard()); //EditText는 john2로 변함

        onView(allOf(withId(R.id.OK), isDisplayed()))    //OK 버튼을 눌려다면 실행
                .perform(click());

        onView(withId(R.id.OK))                         //OK버튼이 있는 View가
                .check(matches(withText("FAILED")));    //text가 FAILED의 문자열을 가지고 있다면 정상처리

    }
}
