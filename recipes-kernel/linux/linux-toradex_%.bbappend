FILESEXTRAPATHS_prepend := "${THISDIR}/files:"


SRC_URI += "git://github.com/gbpereira1/ipeboard_drivers.git;protocol=https;destsuffix=dts-repo;name=ipeboard \
            file://0001-Add-ipeboard-dts.patch \
            file://mcp23s08.cfg \
           "

SRCREV_ipeboard = "${AUTOREV}"
SRCREV_FORMAT = "ipeboard"

do_configure_append() {
    cp ${WORKDIR}/dts-repo/source/ipeboard.dts ${S}/arch/arm/boot/dts/
    cp ${WORKDIR}/dts-repo/source/ipeboard.dtsi ${S}/arch/arm/boot/dts/
}

KERNEL_FEATURES_append = " cfg/mcp23s08.scc"

KERNEL_DEVICETREE += "ipeboard.dtb"