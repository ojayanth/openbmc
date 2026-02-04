# Ensure mkeficapsule can build when efi_capsule is enabled
DEPENDS:append = " gnutls-native"

# Allow recipes/images that hard-depend on 'u-boot' to be satisfied by u-boot-xlnx
PROVIDES:append = " u-boot"
RPROVIDES:${PN}:append = " u-boot"
