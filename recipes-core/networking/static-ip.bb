SUMMARY = "Install static IP configuration for eth0"
LICENSE = "MIT"
SRC_URI += "file://eth0.network"

do_install() {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/eth0.network ${D}${sysconfdir}/systemd/network/
}

FILES:${PN} += "${sysconfdir}/systemd/network"