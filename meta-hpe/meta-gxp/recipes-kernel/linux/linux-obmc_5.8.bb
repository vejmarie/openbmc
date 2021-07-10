KBRANCH ?= "dev-5.8-gxp-openbmc"
LINUX_VERSION ?= "5.8.17"
SRCREV="9c89e6cf4741e96953ca06ec7d8bd854d0282898"

require linux-obmc.inc
require conf/machine/include/fitimage-sign.inc

# OpenBMC loads in kernel features via other mechanisms so this check
# in the kernel-yocto.bbclass is not required
#KERNEL_DANGLING_FEATURES_WARN_ONLY="1"
