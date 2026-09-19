FILESEXTRAPATHS_prepend := "${THISDIR}/files:"


SRC_URI += "git://github.com/gbpereira1/ipeboard_drivers.git;protocol=https;destsuffix=dts-repo \
            file://0001-Add-ipeboard-dts.patch \
           "

SRCREV = "${AUTOREV}"

do_configure_append() {
    cp ${WORKDIR}/dts-repo/source/ipeboard.dts ${S}/arch/arm/boot/dts/
    cp ${WORKDIR}/dts-repo/source/ipeboard.dtsi ${S}/arch/arm/boot/dts/
}

KERNEL_DEVICETREE += "ipeboard.dtb"