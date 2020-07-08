KBRANCH ?= "dev-5.4-gxp-openbmc"
LINUX_VERSION ?= "5.4.43"

SRCREV="17ca9a51994abececa449aef66636013b6be7ac3"
require linux-obmc.inc
require conf/machine/include/fitimage-sign.inc

SRC_URI += "file://phosphor-gpio-keys.scc"
SRC_URI += "file://phosphor-gpio-keys.cfg"
