FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI_append_hpe-network = " file://00-bmc-eth0.network"

FILES_${PN}_append_hpe-network = " ${systemd_system_unitdir}/network/00-bmc-eth0.network"

do_install_append_hpe-network() {
        install -m 644 -D ${WORKDIR}/00-bmc-eth0.network ${D}${systemd_system_unitdir}/network/00-bmc-eth0.network
}
