###### @Inject ######
* used to give permission to dagger to use constructor to make an object of a class which is used as parameter in another class.
* To use dagger2 generated codes for dependency injection we also need an interface `annotated with @Component`.

###### The above @Inject annotation is not possible for scenarios where we are using 3rd party libraries, 
###### there we don't have permission to make changes to codes... ######

###### Alternative to above method is -> modules and provider functions to provide the dependencies..... ######
