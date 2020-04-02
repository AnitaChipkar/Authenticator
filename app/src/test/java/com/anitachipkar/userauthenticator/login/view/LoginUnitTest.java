package com.anitachipkar.userauthenticator.login.view;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.google.common.truth.Truth.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class LoginUnitTest {

    private static final String FAKE_STRING = "Login was successful!";

  /* @Mock
   Context mMockitoContext;
    @Test
    public void readStringFromContext_LocalizedString() {

      LoginActivity loginActivity = new LoginActivity(mMockitoContext);

      // ...when the string is returned from the object under test...
      String result = loginActivity.validate("user@gmail.com","user12345");

      // ...then the result should be the expected one.
        assertThat(result).isEqualTo(FAKE_STRING);

    }
*/
}
