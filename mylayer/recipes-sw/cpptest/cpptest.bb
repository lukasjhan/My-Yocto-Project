SUMMARY = "CPPTEST BINARY FOR YOCTO PROJECT"
DESCRPTION = "JUST PRINT HELLO YOCTO WORLD IN TERMINAL"
AUTHOR = "UNKNOWN ZERO"
HOMEPAGE = "https://gitlab.com/UNKNOWN.UN/yocto_recipe_cpptest"
BUGTRACKER = ""

LICENSE = "MIT"
LIC_FILES_CHKSUM = "\
   file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "https://gitlab.com/UNKNOWN.UN/yocto_recipe_cpptest/-/archive/v.0.1.1/yocto_recipe_cpptest-v.0.1.1.tar.gz;name=archive"
SRC_URI[archive.md5sum] = "5325947b0d9e2bd0571d590ccd16c912"
SRC_URI[archive.sha256sum] = "2443b673f89e092f4ab1bbcfc561a559b9b0370330980aa0fe84b3fe9fd33def"

S = "${WORKDIR}/yocto_recipe_cpptest-v.0.1.1"

# oe_runmake는 타깃 시스템의 맞춰 빌드를 해주는 make입니다. 
EXTRA_OEMAKE = "'CC=${CC}' 'RANLIB=${RANLIB}' 'AR=${AR}' \
   'CFLAGS=${CFLAGS} -I${S}/. -DWITHOUT_XATTR' 'BUILDDIR=${S}'"

do_compile() {
   oe_runmake
}

do_install () {
   oe_runmake install DESTDIR=${D} BINDIR=${bindir} SBINDIR=${sbindir} \
      MANDIR=${mandir} INCLUDEDIR=${includedir}
}

do_configure() {
}

INSANE_SKIP_${PN} = "ldflags"

# 자세한 사항은 https://www.yoctoproject.org/docs/3.1/dev-manual/dev-manual.html 참조.