load("@rules_junit5_external//:junit5.bzl", "java_junit5_test")

java_junit5_test(
    name = "tests",
    srcs = glob([
        "*Test.java",
    ]),
    deps = [
        "//src/main/java/com/resare/nryaml",
        "@maven//:org_yaml_snakeyaml",
    ],
    test_package = "com.resare.nryaml",
)
