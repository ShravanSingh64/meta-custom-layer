SUMMARY = "Building and installing bootgen"
DESCRIPTION = "Building and installing bootgen, a Xilinx tool that lets you stitch binary files together and generate device boot images"

LICENSE = "MIT"

S = "${WORKDIR}/git"

DEPENDS += "openssl"
RDEPENDS:${PN} += "openssl"



SRC_URI = "${REPO};${BRANCHARG}"
SRC_URI = "git://github.com/Xilinx/bootgen.git;protocol=https;tag=${PV}
EXTRA_OEMAKE += 'CROSS_COMPILER="${CXX}" -C ${S}'
CXXFLAGS:append = " -std=c++0x"

TARGET_CC_ARCH += "${LDFLAGS}"

do_install() {
    install -d ${D}${bindir}
    install -Dm 0755 ${S}/bootgen ${D}${bindir}
}

FILES:${PN} = "${bindir}/bootgen"

BBCLASSEXTEND = "native nativesdk"