# pseudolocalize [![](https://jitpack.io/v/soundasleep/pseudolocalize)](https://jitpack.io/#soundasleep/pseudolocalize)

A very simple pseudolocalization library for Java, based on
[https://github.com/tryggvigy/pseudo-localization/](https://github.com/tryggvigy/pseudo-localization/).

Converts text like "hello" into any number of:

- `heelloo`
- `[hello]`
- `ħḗŀŀǿ`
- `[ħḗḗŀŀǿǿ]`
- or any combination of these methods

## Getting started

```groovy
// add to build.gradle
allprojects {
  repositories {
    // ...
    maven { url 'https://jitpack.io' }
  }
}

dependencies {
  implementation 'com.github.soundasleep:pseudolocalize:0.1.0' // or 'main-SNAPSHOT' for the latest build
}
```

You can then refresh your Gradle dependencies to pick up the library.

(If you're using `main-SNAPSHOT`, use `gradlew --refresh-dependencies` to force Gradle to pull the latest copy of all your dependencies.)

## Using

```java
String s = "my input string";
System.out.println(Pseudolocalize.pseudolocalize(s));
  // prints "[ḿẏ īīƞƥŭŭŧ şŧřīīƞɠ]"
```

You can also use the methods `addAccents`, `addBrackets`, or `lengthen`.

## Developing in Eclipse

1. Clone this repository using Git
2. _Import_ > _Existing Gradle Project_ (important – don't just import the root folder)

You can also run `gradlew eclipse` to reset the `.project` and `.classpath` files.
