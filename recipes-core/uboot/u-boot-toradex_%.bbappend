FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
LICENSE = "CLOSED"

SRC_URI += "file://uEnv.txt"

do_install_append() {
  cp ${WORKDIR}/uEnv.txt ${D}/boot/uEnv.txt
}