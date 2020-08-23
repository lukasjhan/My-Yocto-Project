SUMMARY = "Custom image recipe from scratch"
DESCRIPTION = "Directly assign IMAGE_INSTALL and IMAGE_FEATURES for \
               for direct control over image contents."

LICENSE = "MIT"

# We are using the assignment operator (=) below to purposely overwrite
# the default from the core-image class.

# 설치할 레시피를 나열합니다.
IMAGE_INSTALL = "packagegroup-core-boot packagegroup-base-extended \
                 ${CORE_IMAGE_EXTRA_INSTALL} \
		 sudo python3 libyaml libpcap openssl json-c net-tools mtd-utils coreutils \
		 cpptest mysh"

# 이미지 기능을 추가합니다.
IMAGE_FEATURES += "dev-pkgs"

# 상속할 기본 기능들을 적습니다.
inherit core-image
inherit extrausers

ROOT_PASSWORD = "root"
DEV_PASSWORD = "dev"

# 리눅스 유저 셋팅
EXTRA_USERS_PARAMS = "\
   useradd -p `openssl passwd ${DEV_PASSWORD}` dev; \
   usermod -s /usr/bin/mysh dev; \
   usermod -p `openssl passwd ${ROOT_PASSWORD}` root; \
   "

# 자세한 사항은 https://www.yoctoproject.org/docs/3.1/kernel-dev/kernel-dev.html와 https://www.yoctoproject.org/docs/3.1/dev-manual/dev-manual.html 참조.