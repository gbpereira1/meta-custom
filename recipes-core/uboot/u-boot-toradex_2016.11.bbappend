SUMMARY = "Install modified U-boot variables"
LICENSE = "CLOSED"

FILESEXTRAPATHS_prepend := “${THISDIR}/${PN}:”
SRC_URI += "file://uEnv.txt"

do_install_append() {
  cp ${S}/uEnv.txt ${D}/boot/uEnv.txt
}