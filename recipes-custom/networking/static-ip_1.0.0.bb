SUMMARY = "Install static IP configuration for eth0"
LICENSE = "CLOSED"
SRC_URI += "file://eth0.network.ini"

do_install() {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/eth0.network.ini ${D}${sysconfdir}/systemd/network/
}

FILES_${PN} += "${sysconfdir}/systemd/network"