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
	uid=`cat ${IMAGE_ROOTFS}/etc/passwd | grep "${username}:" | awk -F ":" '{print $3}'`
	guid=`cat ${IMAGE_ROOTFS}/etc/passwd | grep "${username}:" | awk -F ":" '{print $4}'`
        cat ${IMAGE_ROOTFS}/etc/passwd
	chown -R ${uid}:${guid} ${IMAGE_ROOTFS}/home/${username}/.ssh
	chmod 600  ${IMAGE_ROOTFS}/home/${username}/.ssh/authorized_keys
	chmod 700 ${IMAGE_ROOTFS}/home/${username}/.ssh
	priv=`cat ${IMAGE_ROOTFS}/etc/group | grep "priv-admin"`
	( grep -v "priv-admin" ${IMAGE_ROOTFS}/etc/group ) &> ${IMAGE_ROOTFS}/etc/group.new
	cp ${IMAGE_ROOTFS}/etc/group.new ${IMAGE_ROOTFS}/etc/group
	rm ${IMAGE_ROOTFS}/etc/group.new
	echo ${priv},${username} >> ${IMAGE_ROOTFS}/etc/group
        fi
}
