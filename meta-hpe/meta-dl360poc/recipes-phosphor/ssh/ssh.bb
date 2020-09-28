DESCRIPTION = "Add ssh public key to the root accounts"

PR = "r0"

LICENSE = "MIT"

#Note: The keys populated here are just as an example,

SRC_URI = "file://id_rsa.pub \
          "
S = "${WORKDIR}"

USER="root"

do_install() {
        install -d ${D}/home/${USER}/.ssh/
        install -m 0755 ${S}/id_rsa.pub ${D}/home/${USER}/.ssh/authorized_keys
}

PACKAGES += "${PN}-server"

FILES_${PN}-server += "/home/${USER}/.ssh/authorized_keys"
