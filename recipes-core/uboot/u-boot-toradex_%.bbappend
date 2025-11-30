FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
LICENSE = "CLOSED"

SRC_URI += "file://uEnv.txt.in"

do_compile_append() {
    sed -e "s|@FDTFILE@|${USER_DEVICETREE}|" \
        ${WORKDIR}/uEnv.txt.in > ${WORKDIR}/uEnv.txt
}

do_install_append() {
    # Remove the symlink created by the .inc
    rm -f ${D}/boot/uEnv.txt
    rm -f ${D}/boot/uEnv-*.txt

    install -m 0644 -D ${WORKDIR}/uEnv.txt ${D}/boot/uEnv.txt
}

do_deploy_append() {
    # Remove the symlink created by the .inc
    rm -f ${DEPLOYDIR}/uEnv.txt
    rm -f ${DEPLOYDIR}/uEnv-*.txt

    install -m 0644 -D ${WORKDIR}/uEnv.txt ${DEPLOYDIR}/uEnv.txt
}

FILES_${PN} += "/boot/uEnv.txt"