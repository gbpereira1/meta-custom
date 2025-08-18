SUMMARY = "Create custom user"
DESCRIPTION = "A simple recipe to add a system user"
LICENSE = "CLOSED"
PR = "r0"

inherit useradd

USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = "-u 1234 -d /home/mainuser -r -s /bin/sh mainuser"

do_install () {
    install -d -m 755 ${D}/home//mainuser

    chown -R mainuser ${D}/home//mainuser
}

FILES_${PN} += "/home/mainuser"