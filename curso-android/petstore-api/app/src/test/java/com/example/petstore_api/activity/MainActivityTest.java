//package com.example.petstore_api.activity;
//
//
//import androidx.test.rule.ActivityTestRule;
//import androidx.test.runner.AndroidJUnit4;
//import androidx.test.espresso.Espresso;
//import androidx.test.espresso.ViewInteraction;
//import androidx.test.espresso.action.ViewActions;
//import androidx.test.espresso.intent.Intents;
//import androidx.test.espresso.intent.matcher.IntentMatchers;
//import androidx.test.espresso.matcher.ViewMatchers;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//@RunWith(AndroidJUnit4.class)
//public class MainActivityTest {
//
//    private MainActivity activity;
//
//    @Before
//    public void setUp() {
//        activity = Robolectric.buildActivity(MainActivity.class).create().resume().get();
//    }
//
//    @Test
//    public void testButtonListClick() {
//        Button buttonList = activity.findViewById(R.id.btn_list);
//        assertNotNull(buttonList);
//
//        // Simula um clique no botão "buttonList"
//        buttonList.performClick();
//
//        // Verifica se a atividade ListActivity foi iniciada corretamente
//        Intent expectedIntent = new Intent(activity, ListActivity.class);
//        Intent actualIntent = shadowOf(activity).getNextStartedActivity();
//        assertNotNull(actualIntent);
//        assertEqualIntents(expectedIntent, actualIntent);
//    }
//
//    @Test
//    public void testButtonCreateClick() {
//        Button buttonCreate = activity.findViewById(R.id.btn_create);
//        assertNotNull(buttonCreate);
//
//        // Simula um clique no botão "buttonCreate"
//        buttonCreate.performClick();
//
//        // Verifica se a atividade CreateActivity foi iniciada corretamente
//        Intent expectedIntent = new Intent(activity, CreateActivity.class);
//        Intent actualIntent = shadowOf(activity).getNextStartedActivity();
//        assertNotNull(actualIntent);
//        assertEqualIntents(expectedIntent, actualIntent);
//    }
//
//    private void assertEqualIntents(Intent expectedIntent, Intent actualIntent) {
//        // Verifica se os componentes são iguais
//        assertEquals(expectedIntent.getComponent(), actualIntent.getComponent());
//
//        // Verifica se os dados extras são iguais
//        assertEquals(expectedIntent.getExtras(), actualIntent.getExtras());
//    }
//
//}
