package com.example.habbitsappcorse24.authentication.presentation.signup.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.habbitsappcorse24.authentication.presentation.login.LoginState
import com.example.habbitsappcorse24.authentication.presentation.login.components.LoginForm
import com.example.habbitsappcorse24.authentication.presentation.signup.SignupEvent
import com.example.habbitsappcorse24.authentication.presentation.signup.SignupState
import com.example.habbitsappcorse24.core.presentation.HabitButton
import com.example.habbitsappcorse24.core.presentation.HabitPasswordTextfield
import com.example.habbitsappcorse24.core.presentation.HabitTextfield
import com.example.habbitsappcorse24.core.presentation.HabitTitle

@Composable
fun SignupForm (
    state : SignupState,
    onEvent: (SignupEvent) ->Unit,
    modifier : Modifier = Modifier
){
    val focusManager = LocalFocusManager.current
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        HabitTitle(title = "Create Your Account")
        Spacer(modifier = Modifier.height(32.dp))
        HabitTextfield(
            value = state.email,
            onValueChange = { onEvent(SignupEvent.EmailChange(it)) },
            placeholder = "Email",
            contentDescription = "Enter email",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 6.dp)
                .padding(horizontal = 20.dp),
            leadingIcon = Icons.Outlined.Email,
            keyboardOptions = KeyboardOptions(
                autoCorrect = false,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(onAny = {
                focusManager.moveFocus(FocusDirection.Next)
            }),
            errorMessage = state.emailError,
            isEnabled = !state.isLoading,
            backgroundColor = Color.White
        )
        HabitPasswordTextfield(
            value = state.password,
            onValueChange = {onEvent(SignupEvent.PasswordChange(it))},
            contentDescription = "Enter password",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 6.dp)
                .padding(horizontal = 20.dp),
            errorMessage = state.passwordError,
            isEnabled = !state.isLoading,
            keyboardOptions = KeyboardOptions(
                autoCorrect = false,
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onAny = {
                focusManager.clearFocus()
                onEvent(SignupEvent.SingUp)
            }),
            backgroundColor = Color.White
        )
        Spacer(modifier = Modifier.height(12.dp))
        HabitButton(
            text = "Create Account",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            isEnabled = !state.isLoading
        ) {
            onEvent(SignupEvent.LogIn)
        }
        TextButton(onClick = { onEvent(SignupEvent.LogIn) }) {
            Text(
                text = buildAnnotatedString {
                    append("Already have an account? ")
                    withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Sign in")
                    }
                },
                color = MaterialTheme.colorScheme.tertiary
            )
        }
    }
}
@Preview
@Composable
fun SignupFormPreview() {
    LoginForm(LoginState(),{},{})
}