SUMMARY = "Add ssh public key to a test account"

PR = "r0"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${HPEBASE}/COPYING.apache-2.0;md5=34400b68072d710fecd0a2940a0d1658"

PROVIDES += "virtual/ssh-config"

inherit bin_package

#Note: The keys populated here are just as an example,

SRC_URI = "file://id_rsa.pub \
          "
S = "${WORKDIR}"

inherit extrausers

EXTRA_USERS_PARAMS="useradd test"

USER="test"

do_install() {
        if [ -f ${S}/id_rsa.pub ]; then \
           install -d ${D}/home/${USER}/.ssh/;
           install -m 0755 ${S}/id_rsa.pub ${D}/home/${USER}/.ssh/authorized_keys;
        fi
}

