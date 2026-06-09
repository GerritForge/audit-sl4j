load(
    "@com_googlesource_gerrit_bazlets//:gerrit_plugin.bzl",
    "gerrit_plugin",
    "gerrit_plugin_test_util",
    "gerrit_plugin_tests",
)

PLUGIN = "audit-sl4j"

gerrit_plugin(
    name = PLUGIN,
    srcs = glob(["src/main/java/**/*.java"]),
    manifest_entries = [
        "Gerrit-PluginName: audit-sl4j",
        "Gerrit-ReloadMode: reload",
        "Gerrit-Module: com.gerritforge.gerrit.plugins.auditsl4j.Module",
        "Gerrit-SshModule: com.gerritforge.gerrit.plugins.auditsl4j.SshModule",
        "Implementation-Title: Gerrit Audit provider for SLF4J",
        "Implementation-URL: https://github.com/GerritForge/audit-sl4j",
    ],
    resources = glob(["src/main/resources/**/*"]),
)

gerrit_plugin_tests(
    name = "audit_sl4j_tests",
    srcs = glob(["src/test/java/**/*Test.java"]),
    plugin = PLUGIN,
    visibility = ["//visibility:public"],
    deps = [
        ":audit_sl4j_util",
    ],
)

gerrit_plugin_test_util(
    name = "audit_sl4j_util",
    srcs = glob(
        ["src/test/java/**/*.java"],
        exclude = ["src/test/java/**/*Test.java"],
    ),
    deps = [
        ":audit-sl4j__plugin",
    ],
)
