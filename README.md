### Prerequisites

Add this maven line to root `settings.gradle`

~~~
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
~~~

-----------------------------------------

### Dependency

Lastly add this line to `build.gradle` file in app module.

~~~
dependencies {
    implementation 'com.github.fovelas:enhanced-activity:1.0.0'
}
~~~

-----------------------------------------

### Data Binding

```java
public final class MainActivity extends EnhancedActivity<ActivityMainBinding> // binding class of your layout
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        super.onDraw(R.layout.activity_main); // must be after onCreate()
    }
}
```

-----------------------------------------

### On Back Pressed

```java
public final class MainActivity extends EnhancedActivity<ActivityMainBinding> // binding class of your layout
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        super.onDraw(R.layout.activity_main); // must be after onCreate()
    }

    @Override
    protected void onBackPressedEnhanced()
    {
        super.onBackPressedEnhanced();
        finish();
    }
}
```

-----------------------------------------

### Init

```java
public final class MainActivity extends EnhancedActivity<ActivityMainBinding> // binding class of your layout
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        super.onDraw(R.layout.activity_main); // must be after onCreate()
    }

    @Override
    protected void onBackPressedEnhanced()
    {
        super.onBackPressedEnhanced();
        finish();
    }

    @Override
    protected void init()
    {
        super.init();
        Toast.makeText(MainActivity.this, "Activity drawed.", Toast.LENGTH_SHORT).show();
    }
}
```