package com.evaneos.evaneostest.di

import androidx.navigation.NavController
import com.evaneos.destinations_list.presentation.navigation.DestinationsListActions
import com.evaneos.evaneostest.NavAppDirections
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class FeatureModuleNavigator @Inject constructor(
    private val navController: NavController,
) : DestinationsListActions {
    override fun navigateToDestinationDetails(destinationId: Long, destinationName: String) {
        navController.navigate(
            NavAppDirections.actionDestinationsListToDestinationDetails(
                destinationId,
                destinationName,
            )
        )
    }
}

@Module
@InstallIn(ActivityComponent::class)
abstract class DestinationsListModule {
    @Binds
    abstract fun bindsDestinationsListActions(navigator: FeatureModuleNavigator): DestinationsListActions
}