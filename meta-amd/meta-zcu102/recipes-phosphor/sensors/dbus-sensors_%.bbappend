FILESEXTRAPATHS:prepend := "${THISDIR}/dbus-sensors:"

PACKAGECONFIG:zynq = "\
    hwmontempsensor \
    fansensor \
    psusensor \
    adcsensor \
    "
