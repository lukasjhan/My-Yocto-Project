# 이 부분은 부가 정보입니다. 옵션입니다.
SUMMARY = "MYSH FOR YOCTO PROJECT"
DESCRPTION = "SIMPLE SHELL FOR TEST"
AUTHOR = "UNKNOWN ZERO"
HOMEPAGE = "https://gitlab.com/UNKNOWN.UN/yocto_recipe_mysh"
BUGTRACKER = ""

# 라이센스 정보는 필수입니다. 파일과 해시값을 입력해줍니다. 기본 위치는 file://${COMMON_LICENSE_DIR} 밑에 있습니다.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "\
   file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# 가져올 파일의 위치를 표시합니다. 압축파일이라면 해시값을 적고, git이라면 commit id를 적어줍니다.
SRC_URI = "https://gitlab.com/UNKNOWN.UN/yocto_recipe_mysh/-/archive/v.0.1.0/yocto_recipe_mysh-v.0.1.0.tar.gz;name=archive"
SRC_URI[archive.md5sum] = "cf2e273c6b5643235b35efe93973792e"
SRC_URI[archive.sha256sum] = "b239741fd20daacef20446159035803f5d538b623bae7d43b543086eb7255fc1"

# S는 압축해제된 파일의 위치입니다. 네이밍 규칙을 지켰으면 수동으로 지정할 필요 없습니다. 
# [네이밍 규칙: https://www.yoctoproject.org/docs/3.1/dev-manual/dev-manual.html#new-recipe-storing-and-naming-the-recipe]
S = "${WORKDIR}/yocto_recipe_mysh-v.0.1.0"

#각 단계별로 어떤 행동을 해야하는지 기술.
do_compile() {
}

do_install () {
    install -d ${D}${bindir}
    install -m 0755 mysh ${D}${bindir}
}

do_configure() {
}

# 자세한 사항은 https://www.yoctoproject.org/docs/3.1/dev-manual/dev-manual.html 참조.