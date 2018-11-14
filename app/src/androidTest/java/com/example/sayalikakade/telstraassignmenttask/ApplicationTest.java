package com.example.sayalikakade.telstraassignmenttask;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.filters.SdkSuppress;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.FragmentTransaction;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

import com.example.sayalikakade.telstraassignmenttask.view.CountryFragment;
import com.example.sayalikakade.telstraassignmenttask.view.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ApplicationTest {

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    @SdkSuppress(minSdkVersion = 16)
    public void testMinSdkVersion() {
        MainActivity activity = (MainActivity) activityTestRule.getActivity();
        assertNotNull("MainActivity is not available", activity);
    }

    @Test
    @SdkSuppress(maxSdkVersion = 28)
    public void testMaxSdkVersion() {
        MainActivity activity = (MainActivity) activityTestRule.getActivity();
        assertNotNull("MainActivity is not available", activity);
    }

    @Test
    public void getFragment() {
        activityTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    MainActivity activity = (MainActivity) activityTestRule.getActivity();
                    FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
                    CountryFragment countryFragment = new CountryFragment();
                    transaction.add(countryFragment, "CountryFragment");
                    transaction.commit();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        onView(withId(R.id.data_recycler_view)).check(matches(isDisplayed()));
        onView(withId(R.id.data_recycler_view)).perform(RecyclerViewActions.scrollToPosition(6));
    }
}
