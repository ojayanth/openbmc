SUMMARY = "APML interface drivers for BMC"
DESCRIPTION = "${SUMMARY}"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

FILESEXTRAPATHS:prepend := "${THISDIR}/linux-aspeed:"

SRC_URI = "git://github.com/amd/apml_modules;protocol=https;branch=master"

SRC_URI += "file://0001-sbtsi-Handle-i2c-probe-as-per-kernel-version.patch \
            file://0002-sbrmi-Handle-i2c-probe-as-per-kernel-version.patch \
            file://0003-sbrmi-apml_alertl-remove-obsolete-of_get_gpio.patch \
"

SRCREV = "ce41d37a9dc988b1cbde7c23d4349c8079783921"

S = "${WORKDIR}/git"

inherit module

do_install:append() {
    install -d ${D}${includedir}/linux
    install -m 0755 ${S}/amd-apml.h ${D}${includedir}/linux/amd-apml.h
}

# autoload if installed
KERNEL_MODULE_AUTOLOAD += "apml_sbrmi apml_sbtsi"
KERNEL_MODULE_PROBECONF += "apml_sbrmi apml_sbtsi"

PACKAGES += "kernel-module-apml_sbrmi kernel-module-apml_sbtsi"
RRECOMMENDS:${PN} += "kernel-module-apml_sbrmi kernel-module-apml_sbtsi"

EXTRA_OEMAKE += " \
     KDIR=${STAGING_KERNEL_DIR} \
"
