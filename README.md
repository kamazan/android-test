# Technical Android Test

## Exercice's goal
 - Use the provided FakeDestinationFetchingService to retrieve a list of holiday destinations
 - Display the destinations with a list of card views and add the ability to navigate to a destination's web url
 - Follow the design guidelines available on [Figma](https://www.figma.com/file/4yIJXkSfo9xACHgG2KN0Yu/App%2FTestAlternantsMobileDestinationGuide?node-id=3%3A77)
 - Build the app using the MVVM design patterns and coroutines

## Architecture
The app is a multi-module project using the "Clean Architecture" principles with data, domain & presentation layers. The following modules are used in the project:

- app: base module containing the single Activity & the app's navigation's graph
- data: fake data provider
- common:data: common classes across data modules
- common:presentation: common classes across presentation modules
- common:test: common classes used for solely testing purposes
- feature:destinations_list:data/domain/presentation: three modules layers in charge of retrieving and displaying destinations
- feature:destination_details:data/domain/presentation: three modules layers in charge of retrieving and displaying destination details

## Technical difficulties
- Using Jetpack Navigation to navigate between modules and keeping the Safe-Args features
- Android's RatingBar not handling vector drawables

## Room for improvements
- Better unit tests coverage
- Handling interactions with the webview in a more "MVVM" way (with the help of databinding?)
- UI tests (not implemented at all)
- Better UI/UX for error handling (instead of plain Snackbars)
- Improve the Github actions for a better CI
- Use of ktlint for a better code formatting
