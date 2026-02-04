FILESEXTRAPATHS:append := ":${THISDIR}/${PN}"
SRC_URI:append = " file://zynq-baseboard.json \
                   file://zynq-chassis.json \
                 "

do_install:append() {
     rm -f ${D}${datadir}/entity-manager/configurations/*.json
     install -d ${D}${datadir}/entity-manager/configurations
     # install -m 0444 ${UNPACKDIR}/zynq-baseboard.json ${D}${datadir}/entity-manager/configurations
     # install -m 0444 ${UNPACKDIR}/zynq-chassis.json ${D}${datadir}/entity-manager/configurations
}
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
