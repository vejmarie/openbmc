DESCRIPTION = "Linux kernel for GXP"
SECTION = "kernel"
LICENSE = "GPLv2"

PROVIDES += "virtual/kernel"

KCONFIG_MODE="--alldefconfig"

KSRC ?= "git://github.com/HewlettPackard/gxp-linux.git;branch=${KBRANCH}"
SRC_URI = "${KSRC}"
SRC_URI += " file://defconfig"

FILESEXTRAPATHS_prepend_linux-obmc := "${THISDIR}/linux-obmc:"

LINUX_VERSION_EXTENSION ?= "-${SRCREV}"

PV = "${LINUX_VERSION}+git${SRCPV}"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

# From 4.16+ the COPYING file changed
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"
