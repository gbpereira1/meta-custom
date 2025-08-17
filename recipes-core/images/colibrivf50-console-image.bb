SUMMARY = "Custom image for Toradex Colibri VF50"
DESCRIPTION = "Angstrom-based image without graphical interface"

LICENSE = "MIT"

#start of the resulting deployable tarball name
export IMAGE_BASENAME = "Console-Image"
IMAGE_NAME_colibri-vf = "Colibri-VF_${IMAGE_BASENAME}"
IMAGE_NAME = "${MACHINE}_${IMAGE_BASENAME}"

SYSTEMD_DEFAULT_TARGET = "graphical.target"

#create the deployment directory-tree
require recipes-core/images/deploy-tasks.inc

IMAGE_LINGUAS = "en-us"


DISTRO_UPDATE_ALTERNATIVES ??= ""
ROOTFS_PKGMANAGE_PKGS ?= '${@oe.utils.conditional("ONLINE_PACKAGE_MANAGEMENT", "none", "", "${ROOTFS_PKGMANAGE} ${DISTRO_UPDATE_ALTERNATIVES}", d)}'

CONMANPKGS ?= "connman connman-plugin-loopback connman-plugin-ethernet connman-plugin-wifi connman-client"

#don't install some id databases
#BAD_RECOMMENDATIONS_append_colibri-vf += " udev-hwdb cpufrequtils "


IMAGE_INSTALL += " \
    angstrom-packagegroup-boot \
    packagegroup-basic \
    udev-extra-rules \
    ${CONMANPKGS} \
    ${ROOTFS_PKGMANAGE_PKGS} \
    timestamp-service \
    packagegroup-base-extended \
    static-ip  \
    mainuser \
"
IMAGE_INSTALL += " \
    \
    alsa-utils \
    alsa-utils-aplay \
    alsa-utils-amixer \
    \
    sqlite3 \
    \
    curl \
    canutils \
    nfs-utils-client \
    openssh-scp \
    openssh-sftp \
    \
    bzip2 \
    gdbserver \
    grep \
    joe \
    minicom \
    ldd \
    lsof \
    mtd-utils \
    dosfstools \
    util-linux-fstrim \
    \
    devmem2 \
    ethtool \
    evtest \
    hdparm \
    iperf3 \
    i2c-tools \
    libsoc \
    lmbench \
    memtester \
    nbench-byte \
    rt-tests \
    stress \
    tinymembench \
    util-linux-lsblk \
    \
"

IMAGE_INSTALL_append_colibri-vf = " \
    u-boot-toradex-fsl-fw-utils \
"

IMAGE_DEV_MANAGER   = "udev"
IMAGE_INIT_MANAGER  = "systemd"
IMAGE_INITSCRIPTS   = " "
IMAGE_LOGIN_MANAGER = "busybox shadow"

inherit core-image
