# Cuttly - Java API Documentation

This little library allows users to use the Cuttly API directly from Java Code. 

### Use it

In order to use this library, you must own an API Key. If you don't have one, you can get one by sign in on
[Cuttly Website](https://cutt.ly)

#### Connect to the service

```java
public static void main(String[] args) {
    CuttlyAPI api = new CuttlyAPI("5b0ec248527eacd602e13dec52c950a3");
}
```

#### Short a link

```java
public static void main(String[] args) {
    CuttlyAPI api = new CuttlyAPI("5b0ec248527eacd602e13dec52c950a3");
    CuttlyLink link = api.cut("https://github.com/Nig3l/cuttly-java-api", "Cuttly-API");
}
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Nig3l** - *Initial work* - [Cuttly-API](https://github.com/Nig3l/cuttly-java-api)

See also the list of [contributors](https://github.com/Nig3l/cuttly-java-api/contributors) who participated in this project.

## License

<[Nig3l](mailto:nig3lpro@gmail.com)> wrote this file. As long as you retain this notice you can do whatever 
you want with this stuff. If we meet some day, and you think this stuff is worth 
it, you can buy me a beer in return. Nig3l
