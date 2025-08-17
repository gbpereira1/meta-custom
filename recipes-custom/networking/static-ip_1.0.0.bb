SUMMARY = "Install static IP configuration for eth0"
LICENSE = "CLOSED"
SRC_URI += "file://wired.network"

do_install() {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/wired.network ${D}${sysconfdir}/systemd/network/
}

FILES_${PN} += "${sysconfdir}/systemd/network"