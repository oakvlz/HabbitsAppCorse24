
package com.example.habbitsappcorse24.onboarding.presentation.components
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.habbitsappcorse24.core.presentation.HabitButton
import com.example.habbitsappcorse24.core.presentation.HabitTitle
import com.example.habbitsappcorse24.onboarding.presentation.OnboardingPageInformation
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingPager(
    pages: List<OnboardingPageInformation>,
    onFinish :()-> Unit,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

  Box(modifier = modifier.background(Color.White)){
      HorizontalPager(count = pages.size, state = pagerState) {index->
          val information = pages[index]
          Column(modifier = Modifier
              .fillMaxSize()
              .padding(20.dp),
          horizontalAlignment = Alignment.CenterHorizontally,
      ) {
              Spacer(modifier = Modifier.height(32.dp))
              HabitTitle(title = information.title)
              Spacer(modifier = Modifier.height(32.dp))
              Image(painter = painterResource(id = information.image),
                  contentDescription =" onboarding",
                  modifier = Modifier.aspectRatio(1f),
                  contentScale = ContentScale.FillHeight
              )
              Spacer(modifier = Modifier.height(32.dp))
              Text(text = information.subtitle.uppercase(),
              style = MaterialTheme.typography.bodyLarge.copy(
                  fontWeight= FontWeight.Bold,
                  color = MaterialTheme.colorScheme.tertiary
              ),
              textAlign = TextAlign.Center
              )
          }
      }
      //la propiedad align sirve solo dentro de una box
      Row(
          modifier = Modifier
              .fillMaxSize()
              .align(Alignment.BottomCenter)
              .padding(top = 660.dp, bottom = 64.dp, start = 16.dp, end = 16.dp),
          verticalAlignment =  Alignment.CenterVertically,
          horizontalArrangement =  Arrangement.SpaceBetween
          ) {
          if (pagerState.currentPage == pages.lastIndex) {
              HabitButton(text = "Get Started", modifier = Modifier.fillMaxWidth()){
                  onFinish()
              }


          } else{
              TextButton(onClick = onFinish) {
                  Text(text = "Skip", color = MaterialTheme.colorScheme.tertiary)
              }
              HorizontalPagerIndicator(pagerState =  pagerState, activeColor =MaterialTheme.colorScheme.tertiary,
                  inactiveColor = MaterialTheme.colorScheme.primary
              )
              TextButton(onClick = {
                  coroutineScope.launch {
                      pagerState.animateScrollToPage(pagerState.currentPage + 1)
                  }
              }) {
                  Text(text = "Next",color = MaterialTheme.colorScheme.tertiary)
              }
          }
      }
  }
}