SUMMARY = "Set first time Uboot variables"
LICENSE = "CLOSED"

SRC_URI = " \
    file://setvar.sh \
    file://setvar.service \
"

S = "${WORKDIR}"

inherit systemd

RDEPENDS_${PN} = "u-boot-toradex-fsl-fw-utils"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/setvar.sh ${D}${bindir}/setvar.sh

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/setvar.service \
        ${D}${systemd_system_unitdir}/
}

SYSTEMD_SERVICE_${PN} = "setvar.service"
SYSTEMD_AUTO_ENABLE = "enable"