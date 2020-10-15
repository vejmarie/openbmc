# Copyright 2020 Hewlett Packard Enterprise Development LP.

PACKAGE_INSTALL_append = " ${@['', 'base-passwd shadow'][bool(d.getVar('SET_SSH_KEYS'))]}"

deploy_ssh_keys () {
	if [ "${SSH_KEYS}" != "" ]; then
            username=`echo ${SSH_KEYS} | awk -F":" '{ print $1}'`
            key_path=`echo ${SSH_KEYS} | awk -F":" '{ print $2}'`
            install -d ${IMAGE_ROOTFS}/home/${username}/.ssh/
            install -m 0755 ${key_path} ${IMAGE_ROOTFS}/home/${username}/.ssh/authorized_keys
         fi
}

USERADDEXTENSION ?= ""

inherit ${USERADDEXTENSION}
