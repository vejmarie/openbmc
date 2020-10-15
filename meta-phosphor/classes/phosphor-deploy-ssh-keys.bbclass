# Copyright 2020 Hewlett Packard Enterprise Development LP.

deploy_local_user () {
        if [ "${SSH_KEYS}" != "" ]; then
        username=`echo ${SSH_KEYS} | awk -F":" '{ print $1}'`
        key_path=`echo ${SSH_KEYS} | awk -F":" '{ print $2}'`
        if [ ! -d ${IMAGE_ROOTFS}/home/${username} ]; then
                perform_useradd "${IMAGE_ROOTFS}" "-R ${IMAGE_ROOTFS} -p '' ${username}"
        fi
        install -d ${IMAGE_ROOTFS}/home/${username}/.ssh/
        install -m 0755 ${key_path} ${IMAGE_ROOTFS}/home/${username}/.ssh/authorized_keys
        fi
}
