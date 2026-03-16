FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PACKAGECONFIG:append:zynq = " boot_type"

SRC_URI += " file://sol-default.override.yml"
