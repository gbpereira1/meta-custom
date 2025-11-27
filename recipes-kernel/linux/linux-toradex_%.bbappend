FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://ipeboard.dts \
            file://ipeboard.dtsi \
            "
SRC_URI += "file://0001-Add-ipeboard-dts.patch"

do_configure_append() {
    cp ${WORKDIR}/ipeboard.dts ${S}/arch/arm/boot/dts/
    cp ${WORKDIR}/ipeboard.dtsi ${S}/arch/arm/boot/dts/
}

KERNEL_DEVICETREE += "ipeboard.dtb"