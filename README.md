# nryaml

This small library aims to make it easier to work with data returned from a yaml parser such as [snakeyaml](https://bitbucket.org/snakeyaml/snakeyaml).
The design is influence from the [antonsjava/json](https://github.com/antonsjava/json) parsing library and the types it returns.

The basic idea is that in Java, navigating a structure built by arbitrary primitive types, maps and lists is verbose and error-prone.
One needs to cast the data to be able to traverse it, and little library offers a convenient way chaining method calls instead.

## License

This code is licensed under the Apache License version 2.0, please see LICENSE for additional details.