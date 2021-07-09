inherit obmc-phosphor-systemd
SUMMARY = "Virutal NIC for HPE GXP"
SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "virtualnic.service"
SRC_URI_append = " file://virtualnic.service file://LICENSE file://virtualnic "

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${WORKDIR}/LICENSE;md5=89aea4e17d99a7cacdbeed46a0096b10"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
#FILES_${PN} += "${D}${sysconfigdir}/system/virtualnic.service"

do_install_append() {
  install -d ${D}${sysconfdir}/system/
  install -m 0644 ${WORKDIR}/virtualnic.service ${D}${sysconfdir}/system/virtualnic.service
  install -d ${D}${sysconfdir}/virtualnic
  install -m 0755 ${WORKDIR}/virtualnic ${D}${sysconfdir}/virtualnic/virtualnic
}
