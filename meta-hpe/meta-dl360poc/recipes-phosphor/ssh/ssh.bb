SUMMARY = "Add ssh public key to the root account"

PR = "r0"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${HPEBASE}/COPYING.apache-2.0;md5=34400b68072d710fecd0a2940a0d1658"

inherit native
#Note: The keys populated here are just as an example,

SRC_URI = "file://id_rsa.pub \
          "
S = "${WORKDIR}"

USER="root"

do_install() {
        install -d ${D}/home/${USER}/.ssh/
        install -m 0755 ${S}/id_rsa.pub ${D}/home/${USER}/.ssh/authorized_keys
        echo 'SSH SETUP' > ${D}/home/${USER}/ssh
}

